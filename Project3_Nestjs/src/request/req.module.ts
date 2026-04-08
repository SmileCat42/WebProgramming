import { Module } from '@nestjs/common';
import { RequestController } from './req.controller';
import { RequestService } from './req.service';

@Module({
  controllers: [RequestController],
  providers: [RequestService],
})
export class RequestModule {}