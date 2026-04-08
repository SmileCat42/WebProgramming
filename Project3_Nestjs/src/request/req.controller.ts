import { Controller, Get, Post, Body, Render } from '@nestjs/common';
import { RequestService } from './req.service';

@Controller('request')
export class RequestController {

  constructor(private requestService: RequestService) {}

  @Post()
  async submitForm(@Body() body: any) {
    await this.requestService.create(
      body.req_name,
      body.req_tel,
      body.req_mes
    );

    return { success: true };
  }
}
