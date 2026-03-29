import { Controller, Get, Render } from '@nestjs/common';
import { PromotionService } from './promotion.service';

@Controller('promotion') // Route: /promotion
export class PromotionController {
  constructor(private readonly promotionService: PromotionService) {}

  @Get() // GET /promotion
  @Render('promotion') // เรนเดอร์ไฟล์ promotion.ejs
  async getPromotionPage() {
    const promotions = await this.promotionService.findAll();
    return { 
      promotions: promotions, // ส่งข้อมูลไปหน้า EJS
      title: 'โปรโมชั่นพิเศษ',
      user: null
    };
  }
}