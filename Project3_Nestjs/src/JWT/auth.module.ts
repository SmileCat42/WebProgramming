import { Module, forwardRef } from '@nestjs/common';
import { JwtModule } from '@nestjs/jwt';
import { PassportModule } from '@nestjs/passport'; // 👈 1. เพิ่มอันนี้
import { AuthService } from './auth.service';
import { AuthController } from './auth.controller';
import { UserModule } from '../user/user.module'; // เช็ค Path เทอด้วยนะจ๊ะ
import { JwtStrategy } from './auth.strategy'; // 👈 2. เพิ่มไฟล์ Strategy ที่เราเขียนกัน


@Module({
  imports: [
    forwardRef(() => UserModule),
    // 👈 3. ลงทะเบียน Passport และบอกว่าเราจะใช้ 'jwt' เป็นหลัก
    PassportModule.register({ defaultStrategy: 'jwt' }), 
    JwtModule.register({
      secret: 'MY_SECRET_PINK_DOLL',
      signOptions: { expiresIn: '1d' },
    }),
  ],
  // 👈 4. ต้องใส่ JwtStrategy ใน providers เพื่อให้ระบบเรียกใช้ได้
  providers: [AuthService, JwtStrategy], 
  controllers: [AuthController],
  // 👈 5. Export PassportModule ออกไป เผื่อ Module อื่น (เช่น KeyModule) จะใช้ Guard
  exports: [AuthService, PassportModule], 
})
export class AuthModule {}