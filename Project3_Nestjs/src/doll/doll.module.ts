import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Doll } from './doll.entity';
import { Key } from '../key/key.entity';
import { DollService } from './doll.service';
import { DollController } from './doll.controller';

@Module({
  imports: [TypeOrmModule.forFeature([Doll, Key])],
  controllers: [DollController],
  providers: [DollService],
})
export class DollModule {}