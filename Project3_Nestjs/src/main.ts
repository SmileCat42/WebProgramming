import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import { NestExpressApplication } from '@nestjs/platform-express';
import { Transport } from '@nestjs/microservices'; // <--- เพิ่มอันนี้
import { join } from 'path';
import * as express from 'express';
import session from 'express-session';
import 'reflect-metadata';

async function bootstrap() {
  const app = await NestFactory.create<NestExpressApplication>(AppModule);

  // --- ส่วนของ Microservice (TCP) ---
  app.connectMicroservice({
    transport: Transport.TCP,
    options: {
      host: '0.0.0.0', // หรือ '127.0.0.1'
      port: 3001,      // พอร์ตสำหรับให้ Service อื่นมาคุยด้วย
    },
  });

  // สั่งให้ Microservice เริ่มทำงาน (สำคัญมาก)
  await app.startAllMicroservices();

  // --- ส่วนของ Web (EJS/Express) เดิมของคุณ ---
  app.use(express.json());
  app.use(express.urlencoded({ extended: true }));

  app.setBaseViewsDir(join(process.cwd(), 'views'));
  app.setViewEngine('ejs');

  app.use(
    session({
      secret: 'doll-gift-shop-secret',
      resave: false,
      saveUninitialized: false,
      cookie: { maxAge: 3600000 },
    }),
  );

  app.useStaticAssets(join(__dirname, '..', 'public'));

  // รัน HTTP ที่พอร์ต 3000
  await app.listen(3000);
  
  console.log(`Web Application (EJS) is running on: http://localhost:3000`);
  console.log(`Microservice (TCP) is listening on port: 3001`);
}
bootstrap();