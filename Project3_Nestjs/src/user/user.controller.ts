// เพิ่ม Post, Body, Res, Render เข้าไปใน { ... }
import { Controller, Get, Post, Body, Res, Render, Session } from '@nestjs/common';
import { UserService } from './user.service';

@Controller('auth')
export class UserController {
  constructor(private readonly userService: UserService) {}

  @Get('login')
  @Render('login') // ตรวจสอบว่ามีไฟล์ views/login.ejs แล้ว
  getLogin() {
    return { error: null,
        user: null
     }; // ส่ง error เป็น null ไปก่อนเพื่อไม่ให้ EJS พัง
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
}