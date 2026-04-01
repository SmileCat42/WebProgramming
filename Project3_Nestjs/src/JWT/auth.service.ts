import { Injectable } from '@nestjs/common';
import { JwtService } from '@nestjs/jwt'; 
import { UserService } from '../user/user.service'; // เช็ค Path ให้ถูกนะจ๊ะ

@Injectable()
export class AuthService {
  constructor(
    private readonly userService: UserService,
    private readonly jwtService: JwtService,
  ) {}

  // 1. เพิ่มฟังก์ชันนี้เข้าไปจ่ะ เพื่อเช็คว่า ID/Pass ใน DB ถูกไหม
  async validateUser(userId: string, pass: string): Promise<any> {
    const user = await this.userService.findOne(userId); // สมมติว่าใน UserService มี findOne
    
    if (user && user.user_pass === pass) {
      // ถ้าผ่าน ให้ดึงแค่ข้อมูลที่จำเป็นออกมา (ไม่ส่ง Password กลับไป)
      const { user_pass, ...result } = user;
      return result;
    }
    return null; // ถ้าไม่ผ่าน ส่ง null กลับไป
  }

  // 2. ฟังก์ชันออกบัตร JWT (ที่คุยกันรอบที่แล้ว)
  async login(user: any) {
    const payload = { 
      username: user.user_id, 
      fname: user.user_fname 
    };

    return {
      access_token: this.jwtService.sign(payload),
      fname: user.user_fname,
    };
  }
}