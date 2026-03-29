import { Controller, Get, Render, Param, Post, Body, Delete, Put, Res } from '@nestjs/common';
import { Response } from 'express';
import { DollService } from './doll.service';
import { KeyService } from '../key/key.service';

@Controller()
export class DollController {

  constructor(
  private service: DollService,
  private keyService: KeyService
) {}

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
    keys: await this.keyService.findAll(),
    user: null
  };
}


}