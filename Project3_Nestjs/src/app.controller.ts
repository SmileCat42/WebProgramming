import { Controller, Get, Render } from '@nestjs/common';
import { AppService } from './app.service';
import { DollService } from './doll/doll.service';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService,
    private service: DollService
  ) { }

  @Get('/index')
@Render('index')
async page() {
  return { list: await this.service.findAll() };
}
  
  @Get('/hello')
  getHello(): string {
    return this.appService.getHello();
  }
}
