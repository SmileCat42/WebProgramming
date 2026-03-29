import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { Promotion } from './promotion.entity';

@Injectable()
export class PromotionService {
  constructor(
    @InjectRepository(Promotion)
    private readonly promotionRepository: Repository<Promotion>,
  ) {}

  // ฟังก์ชันดึงข้อมูลโปรโมชั่นทั้งหมด
  findAll(): Promise<Promotion[]> {
    return this.promotionRepository.find({
      order: {
        promotion_id: 'DESC',
      },
    });
  }
}