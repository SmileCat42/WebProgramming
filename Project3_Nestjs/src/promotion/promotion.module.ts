import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { ClientsModule, Transport } from '@nestjs/microservices'; // <--- 1. เพิ่มการ Import นี้
import { Promotion } from './promotion.entity';
import { PromotionService } from './promotion.service';
import { PromotionController } from './promotion.controller';

@Module({
  imports: [
    TypeOrmModule.forFeature([Promotion]),
    // 2. เพิ่ม ClientsModule เพื่อให้ Controller ส่งข้อมูลผ่าน TCP ได้
    ClientsModule.register([
      {
        name: 'PROMOTION_SERVICE', // ชื่อ Token ที่จะใช้ @Inject ใน Controller
        transport: Transport.TCP,
        options: {
          host: '127.0.0.1', // รันในเครื่องตัวเอง
          port: 3001,        // พอร์ต Microservice ที่เราตั้งไว้ใน main.ts
        },
      },
    ]),
  ],
  providers: [PromotionService],
  controllers: [PromotionController],
})
export class PromotionModule {}
//ngrok http 3000 รัน