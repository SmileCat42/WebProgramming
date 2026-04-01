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
    const newUser = this.userRepository.create({
      ...userData,
      // ✨ ใส่ต่อท้ายแบบนี้ เพื่อให้มั่นใจว่าต่อให้ userData มี role อะไรมา 
      // เราจะบังคับใช้ 'MEMBER' (หรือ 'CUSTOM' ตามที่เทอชอบ) เสมอ
      user_role: userData.user_role || 'MEMBER', 
    });
    
    return await this.userRepository.save(newUser); 
}
}