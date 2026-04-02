import { Controller, Get, Post, Body, Res, Render, Session, HttpStatus } from '@nestjs/common';
import { UserService } from './user.service';
import { AuthService } from '../JWT/auth.service';
import { Response } from 'express';

@Controller('auth')
export class UserController {
  constructor(private readonly userService: UserService,
    private readonly authService: AuthService,
  ) { }

  @Get('login')
@Render('login')
getLogin(@Session() session: any) { // 👈 เพิ่ม @Session เข้ามาเช็ค
  // ถ้าเขา Login ค้างไว้อยู่แล้ว (session.user มีค่า) 
  // ก็ให้เด้งไปหน้า promotion เลย ไม่ต้องให้เขา Login ซ้ำจ่ะ
  if (session.user) {
    return { 
      user: session.user, 
      error: null 
    };
    // หรือจะ res.redirect('/promotion') ก็ได้นะจ๊ะ ถ้าอยากให้ข้ามหน้าไปเลย
  }

  return {
    error: null,
    user: null // 👈 ส่งไปเพื่อให้ header.ejs ไม่พ่น Error ว่าหาตัวแปร user ไม่เจอ
  };
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
    // 1. ฝากใน Session (เพื่อให้ EJS โชว์ชื่อได้)
    session.user = user; 

    // 2. สร้าง Token (สมมติว่าเทอมี AuthService เตรียมไว้แล้ว)
    // payload ต้องมี role: user.role ด้วยนะจ๊ะ ยามจะได้รู้ว่าเป็น ADMIN ไหม
    const token = await this.authService.generateToken(user); 

    // 3. ส่ง Token ไปทาง URL Query (วิธีที่ง่ายที่สุดเวลาใช้ redirect)
    // เพื่อให้หน้าบ้านแอบก๊อปไปลง localStorage
    return res.redirect(`/promotion?access_token=${token}`);

  } else {
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