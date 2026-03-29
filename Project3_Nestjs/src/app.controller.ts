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
  async getIndex() {
    return { user: null, // ส่งค่า null ไปก่อนเพื่อให้ EJS รู้จักตัวแปรนี้
    title: 'Home' };
  }

  @Get('manage')
  @Render('manage')
  async getManage() {
    return { 
      dolls: await this.dollService.findAll(),
      keys: await this.keyService.findAll(),
      user: null
    };
  }

  @Get('/hello')
  getHello(): string {
    return this.appService.getHello();
  }
}