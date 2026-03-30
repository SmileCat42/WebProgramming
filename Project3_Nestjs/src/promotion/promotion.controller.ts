import { Controller, Get, Render, Req, Session } from '@nestjs/common';
import { PromotionService } from './promotion.service';
import { Request } from 'express'; // ต้อง import Request จาก express มาด้วยนะจ๊ะ

@Controller('promotion')
export class PromotionController {
  constructor(private readonly promotionService: PromotionService) { }

  @Get()
  @Render('promotion')
  async getPromotion(@Session() session: any) {
    const allPromotions = await this.promotionService.findAll();

    return {
      promotions: allPromotions,
      user: session.user || null // ✅ ดึงจาก Session ถ้าไม่มีจะเป็น null
    };
  }
}