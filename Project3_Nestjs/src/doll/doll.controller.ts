import { Controller, Get, Render, Param, Post, Body, Delete, Put } from '@nestjs/common';
import { DollService } from './doll.service';

@Controller()
export class DollController {

  constructor(private service: DollService) {}

  @Get()
  @Render('index')
  async page() {
    return { list: await this.service.findAll() };
  }

  @Get('api/doll/:id')
  getOne(@Param('id') id: number) {
    return this.service.findOne(id);
  }

  @Post('api/doll')
  create(@Body() body) {
    return this.service.create(body);
  }

  @Put('api/doll/:id')
  update(@Param('id') id: number, @Body() body) {
    return this.service.update(id, body);
  }

  @Delete('api/doll/:id')
  delete(@Param('id') id: number) {
    return this.service.remove(id);
  }

}