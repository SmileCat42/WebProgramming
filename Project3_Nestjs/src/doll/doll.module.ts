import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Doll } from './doll.entity';
import { DollService } from './doll.service';
import { DollController } from './doll.controller';

@Module({
  imports: [TypeOrmModule.forFeature([Doll])],
  controllers: [DollController],
  providers: [DollService],
})
export class DollModule {}