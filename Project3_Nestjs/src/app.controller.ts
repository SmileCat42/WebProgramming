import { Controller, Get, Render } from '@nestjs/common';
import { AppService } from './app.service';
import { DollService } from './doll/doll.service';
import { KeyService } from './key/key.service';

@Controller()
export class AppController {
  constructor(
    private readonly appService: AppService,
    private readonly dollService: DollService,
    private readonly keyService: KeyService
  ) {}

  @Get()
  @Render('index')
  async page() {
    return { 
      dolls: await this.dollService.findAll(),
      keys: await this.keyService.findAll()
    };
  }

  @Get('/hello')
  getHello(): string {
    return this.appService.getHello();
  }
}