import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { ResumeModule } from './resume/resume.module';

@Module({
  imports: [
    TypeOrmModule.forRoot({
      type: 'mysql',
      host: 'localhost',
      port: 3306,
      username: 'root',
      password: '1234',
      database: 'test3',
      autoLoadEntities: true,
      synchronize: true,
    }),
    ResumeModule, // ⭐ ตรงนี้แหละที่ต้องมี
  ],
})
export class AppModule {}
