import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { User } from './user.entity';

@Injectable()
export class UserService {
  constructor(
    @InjectRepository(User)
    private userRepository: Repository<User>,
    
  ) {}

  // ฟังก์ชันสำหรับเช็ค Login
  async findOne(user_id: string): Promise<User | null> {
    return this.userRepository.findOne({ where: { user_id } });
  }

  // user.service.ts
async signup(userData: Partial<User>) {
    // 1. สร้างก้อนข้อมูลใหม่จาก Class User
    const newUser = this.userRepository.create(userData); 
    // 2. บันทึกลง DB (ตัวแปร repo คือที่ฉีดยาเข้ามาจ่ะ)
    return await this.userRepository.save(newUser); 
}
}