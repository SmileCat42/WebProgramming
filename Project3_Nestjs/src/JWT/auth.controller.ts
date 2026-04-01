import { Controller, Post, Body, Res, HttpStatus } from '@nestjs/common';
import { AuthService } from './auth.service';
import type { Response } from 'express';

@Controller('auth')
export class AuthController {
  constructor(private readonly authService: AuthService) {}

  @Post('login')
  async login(@Body() body: any, @Res() res: Response) {
    const { user_id, user_pass } = body;

    // 1. ไปเรียกใช้ Service เพื่อตรวจสอบ User (สมมติว่าเทอมีฟังก์ชัน validate ใน Service นะจ๊ะ)
    // หรือถ้าจะเอาแบบ "พื้นๆ" ตามที่คุยกัน คือเช็คตรงๆ หรือส่งไปให้ AuthService จัดการ
    const user = await this.authService.validateUser(user_id, user_pass);

    if (user) {
      // 2. ถ้าผ่าน! ให้ AuthService ออกบัตร JWT
      const loginResult = await this.authService.login(user);
      
      // 3. ส่ง Token และชื่อกลับไปให้หน้าบ้าน (Client)
      return res.status(HttpStatus.OK).json(loginResult);
    } else {
      // 4. ถ้าไม่ผ่าน! ส่ง Error กลับไป
      return res.status(HttpStatus.UNAUTHORIZED).json({
        message: 'ID หรือรหัสผ่านไม่ถูกต้องจ้า ❌',
      });
    }
  }
}