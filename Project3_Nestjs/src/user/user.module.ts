import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { UserService } from './user.service';
import { UserController } from './user.controller';
import { User } from './user.entity';

@Module({
  imports: [TypeOrmModule.forFeature([User])], // บอก Nest ให้รู้จักตาราง User
  providers: [UserService],
  controllers: [UserController],
  exports: [UserService], // เผื่อเอาไปใช้ใน Module อื่น (เช่น Auth)
})
export class UserModule {}