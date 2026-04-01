import { Module } from '@nestjs/common';
import { AuthService } from './auth.service';
import { AuthController } from './auth.controller';
import { JwtModule } from '@nestjs/jwt'; // ต้องมีตัวนี้
import { UserModule } from '../user/user.module'; // นำเข้า UserModule มาใช้ร่วมกัน

@Module({
  imports: [
    UserModule,
    JwtModule.register({
      secret: 'MY_SECRET_PINK_DOLL', // รหัสลับสำหรับเซ็นชื่อบัตร
      signOptions: { expiresIn: '1d' }, // บัตรมีอายุ 1 วัน
    }),
  ],
  providers: [AuthService],
  controllers: [AuthController],
  exports: [AuthService], // เผื่อ Module อื่นอยากเรียกใช้
})
export class AuthModule {}