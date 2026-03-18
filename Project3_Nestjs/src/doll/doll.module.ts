import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Doll } from './doll.entity';
import { Key } from '../key/key.entity';
import { DollService } from './doll.service';
import { DollController } from './doll.controller';
import { KeyModule } from '../key/key.module';

@Module({
  imports: [
    TypeOrmModule.forFeature([Doll]),
    KeyModule
  ],
  controllers: [DollController],
  providers: [DollService],
  exports: [DollService]
})
export class DollModule {}