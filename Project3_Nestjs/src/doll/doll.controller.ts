import { Controller, Get, Render, Param, Post, Body, Delete, Put, Res } from '@nestjs/common';
import { Response } from 'express';
import { DollService } from './doll.service';

@Controller()
export class DollController {

  constructor(private service: DollService) { }

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

  @Get('/show')
  @Render('show')
  async showPage() {
    return {
      dolls: await this.service.findAll(),
      keys: await this.service.getKeys()
    };
  }

  @Get('/key')
  @Render('show')
  async getKey() {
    return { products: await this.service.getKeys() };
  }



}