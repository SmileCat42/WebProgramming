import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Promotion } from './promotion.entity';
import { PromotionService } from './promotion.service';
import { PromotionController } from './promotion.controller';

@Module({
  imports: [TypeOrmModule.forFeature([Promotion])], // ลงทะเบียน Entity สำหรับ Module นี้
  providers: [PromotionService],
  controllers: [PromotionController],
})
export class PromotionModule {}