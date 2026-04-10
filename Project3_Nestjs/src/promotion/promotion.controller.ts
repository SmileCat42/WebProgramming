// promotion.controller.ts
import { Controller, Get, Render, Session, Inject } from '@nestjs/common';
import { ClientProxy } from '@nestjs/microservices';
import { firstValueFrom } from 'rxjs'; // ช่วยแปลง Observable เป็น Promise
import { PromotionService } from './promotion.service';
import { MessagePattern } from '@nestjs/microservices'; // <--- 1. เพิ่ม Import อันนี้

@Controller('promotion')
export class PromotionController {
  constructor(
    @Inject('PROMOTION_SERVICE') private client: ClientProxy,
    private readonly promotionService: PromotionService, // ฉีด service เข้ามาด้วย
  ) {}

  // --- ส่วนของ HTTP (คนส่ง) ---
  @Get()
  @Render('promotion')
  async getPromotion(@Session() session: any) {
    // ส่งไปหาตัวเองผ่าน TCP พอร์ต 3001
    const allPromotions = await firstValueFrom(
      this.client.send({ cmd: 'get_all_promotions' }, {})
    );

    return {
      promotions: allPromotions,
      user: session.user || null
    };
  }

  // --- ส่วนของ TCP (คนรับ) ---
  // ย้ายจาก Service มาไว้ที่นี่เพื่อความชัวร์ว่า Microservice จะหาเจอ
  @MessagePattern({ cmd: 'get_all_promotions' })
  async handleGetAllPromotions() {
    console.log('TCP Receipt: Someone requested promotions!');
    return await this.promotionService.findAll(); // เรียกใช้ Logic จาก Service เดิม
  }
}