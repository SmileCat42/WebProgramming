import { Module, forwardRef } from '@nestjs/common'; // เพิ่ม forwardRef
import { TypeOrmModule } from '@nestjs/typeorm';
import { UserService } from './user.service';
import { UserController } from './user.controller';
import { User } from './user.entity';
import { AuthModule } from '../JWT/auth.module';

@Module({
  // ใช้ forwardRef หุ้ม AuthModule
  imports: [
    TypeOrmModule.forFeature([User]),
    forwardRef(() => AuthModule), 
  ],
  providers: [UserService],
  controllers: [UserController],
  exports: [UserService],
})
export class UserModule {}