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
}