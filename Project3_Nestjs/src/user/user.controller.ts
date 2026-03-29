// เพิ่ม Post, Body, Res, Render เข้าไปใน { ... }
import { Controller, Get, Post, Body, Res, Render } from '@nestjs/common';
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
  async login(@Body() body, @Res() res) {
    const { user_id, user_pass } = body;
    const user = await this.userService.findOne(user_id);

    // เช็คว่าเจอ User ไหม และรหัสผ่านตรงกันไหม
    if (user && user.user_pass === user_pass) {
      // ถ้าผ่าน ให้ไปหน้าโปรโมชั่น
      return res.redirect('/promotion');
    } else {
      // ถ้าไม่ผ่าน ส่งกลับไปหน้า Login พร้อมข้อความ Error
      return res.render('login', { error: 'ID หรือรหัสผ่านไม่ถูกต้องจ้า' });
    }
  }
}