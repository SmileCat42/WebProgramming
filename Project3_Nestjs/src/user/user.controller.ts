import { Controller, Get, Post, Body, Res, Render, Session, HttpStatus } from '@nestjs/common';
import { UserService } from './user.service';
import { Response } from 'express';

@Controller('auth')
export class UserController {
  constructor(private readonly userService: UserService) { }

  @Get('login')
  @Render('login') // ตรวจสอบว่ามีไฟล์ views/login.ejs แล้ว
  getLogin() {
    return {
      error: null,
      user: null
    }; // ส่ง error เป็น null ไปก่อนเพื่อไม่ให้ EJS พัง
  }

  @Get('regis')
  @Render('regis')
  toregis() {
    return {
      error: null,
      user: null
    };
  }

  @Post('login')
  async login(@Body() body, @Res() res, @Session() session: any) {
    const { user_id, user_pass } = body;
    const user = await this.userService.findOne(user_id);

    if (user && user.user_pass === user_pass) {
      session.user = user; // ✅ ฝากข้อมูล User ไว้ใน Session
      return res.redirect('/promotion');
    } else {
      // ส่ง user: null ไปด้วยเพื่อไม่ให้ header.ejs พัง
      return res.render('login', { error: 'ID หรือรหัสผ่านไม่ถูกต้องจ้า', user: null });
    }
  }

  @Get('logout')
  logout(@Session() session: any, @Res() res) {
    session.destroy(); // 💥 สั่งทำลายสมุดจดบันทึก (ลบข้อมูลการ Login)
    return res.redirect('/auth/login'); // เด้งกลับไปหน้า Login
  }

  @Post('signup')
  async handleSignup(@Body() body: any, @Res() res: any) {
    try {
      await this.userService.signup(body);

      // ✅ แก้ตรงนี้: HttpStatus.OK เฉยๆ ไม่มีวงเล็บจ่ะ
      return res.status(HttpStatus.OK).json({
        message: 'สมัครสมาชิกสำเร็จแล้วจ้า! 🧸'
      });

    } catch (error) {
      // ❌ ตรงนี้ก็เหมือนกันจ่ะ: HttpStatus.BAD_REQUEST เฉยๆ
      return res.status(HttpStatus.BAD_REQUEST).json({
        message: 'สมัครไม่สำเร็จนะจ๊ะ อาจจะมี ID นี้อยู่แล้ว'
      });
    }
  }
}