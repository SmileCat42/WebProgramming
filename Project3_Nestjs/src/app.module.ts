import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { ServeStaticModule } from '@nestjs/serve-static';
import { join } from 'path';
import { Doll } from './doll/doll.entity';
import { Key } from './key/key.entity';
import { User } from './user/user.entity';
import { Promotion } from './promotion/promotion.entity';
import { DollModule } from './doll/doll.module';
import { KeyModule } from './key/key.module';
import { PromotionModule } from './promotion/promotion.module';
import { UserModule } from './user/user.module';
import { AuthModule } from './JWT/auth.module';

import { AppController } from './app.controller'; 
import { AppService } from './app.service';

@Module({
  imports: [
    // โหลดไฟล์รูปจาก public
    ServeStaticModule.forRoot({
      rootPath: join(process.cwd(), 'public'), 
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
      entities: [Doll, Key, Promotion, User],
      autoLoadEntities: true,
      synchronize: false,
      
    }),

    DollModule,
    KeyModule, 
    PromotionModule,
    UserModule,
    AuthModule,
  ],
  controllers: [AppController], 
  providers: [AppService],  
})
export class AppModule {}