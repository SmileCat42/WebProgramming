import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import { NestExpressApplication } from '@nestjs/platform-express';
import { join } from 'path';
import * as express from 'express';
import 'reflect-metadata';

async function bootstrap() {

  // ⭐ บอก NestJS ว่าใช้ Express
  const app = await NestFactory.create<NestExpressApplication>(AppModule);

  app.use(express.json()); 

  // ⭐ โฟลเดอร์ views (EJS)
  app.setBaseViewsDir(join(process.cwd(), 'views')); // OK

  // ⭐ ใช้ ejs
  app.setViewEngine('ejs');


  // ⭐ ให้ AJAX อ่าน JSON ได้
  app.use(express.json());
  app.use(express.urlencoded({ extended: true }));

  // ⭐ static files (css/js)
  app.useStaticAssets(join(__dirname, '..', 'public'), {
});

  await app.listen(3000);
}
bootstrap();
