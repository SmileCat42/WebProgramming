import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { ServeStaticModule } from '@nestjs/serve-static';
import { join } from 'path';
import { Doll } from './doll/doll.entity';
import { Key } from './key/key.entity';
import { DollModule } from './doll/doll.module';
import { KeyModule } from './key/key.module';
// ⚠️ อย่าลืม Import 2 ตัวนี้
import { AppController } from './app.controller'; 
import { AppService } from './app.service';

@Module({
  imports: [
    // โหลดไฟล์รูปจาก public
    ServeStaticModule.forRoot({
      rootPath: join(process.cwd(), 'public'), // ใช้ process.cwd() จะชัวร์กว่าครับ
      serveRoot: '/public', // ให้เข้าถึงผ่าน /public/filename.jpg
    }),

    // เชื่อม database
    TypeOrmModule.forRoot({
      type: 'mysql',
      host: 'localhost',
      port: 3306,
      username: 'root',
      password: 'Golfring02',
      database: 'gift',
      entities: [Doll, Key],
      autoLoadEntities: true,
      synchronize: true,
    }),

    DollModule,
    KeyModule, // ⚠️ เพิ่ม KeyModule เข้ามาตรงนี้ด้วยครับ
  ],
  controllers: [AppController], // ⚠️ ต้องมีตัวนี้ Route / ถึงจะทำงาน
  providers: [AppService],     // ⚠️ และตัวนี้ด้วย
})
export class AppModule {}