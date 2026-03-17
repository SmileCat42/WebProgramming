import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { ServeStaticModule } from '@nestjs/serve-static';
import { join } from 'path';
import { Doll } from './doll/doll.entity';
import { Key } from './key/key.entity';
import { DollModule } from './doll/doll.module';
import { KeyModule } from './key/key.module';

@Module({
  imports: [

    // โหลดไฟล์รูปจาก public
    ServeStaticModule.forRoot({
      rootPath: join(__dirname, '..', 'public'),
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
  ],
})
export class AppModule {}