import { Controller, Get, Render, Session } from '@nestjs/common';
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
  async getIndex(@Session() session: any) {
    return { user: session.user || null, // ส่งค่า null ไปก่อนเพื่อให้ EJS รู้จักตัวแปรนี้
    title: 'Gift me - ร้านตุ๊กตา พวงกุญแจ กล่องสุ่ม',
    description: 'ขายตุ๊กตาทุกชนิด ตุ๊กตาหมี ตุ๊กตาแมว คุณภาพดี ส่งไว ได้ของแน่นอน',
    canonical: 'https://yourstore.com/' };
  }

  @Get('manage')
  @Render('manage')
  async getManage(@Session() session: any) {
    return { 
      dolls: await this.dollService.findAll(),
      keys: await this.keyService.findAll(),
      user: session.user || null
    };
  }

  @Get('contact')
  @Render('contact')
  async getContact(@Session() session: any) {
    return { 
      dolls: await this.dollService.findAll(),
      keys: await this.keyService.findAll(),
      user: session.user || null
    };
  }

  @Get('/hello')
  getHello(): string {
    return this.appService.getHello();
  }
}