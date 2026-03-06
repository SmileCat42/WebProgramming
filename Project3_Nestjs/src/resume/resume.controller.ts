import { Controller, Get, Render, Param, Post, Body, Delete, Put } from '@nestjs/common';
import { ResumeService } from './resume.service';

@Controller()
export class ResumeController {

  constructor(private service: ResumeService) {}

  // หน้าเว็บ
  @Get()
  @Render('index')
  async page() {
    return { list: await this.service.findAll() };
  }

  // GET one (AJAX)
  @Get('api/resume/:id')
  getOne(@Param('id') id: number) {
    return this.service.findOne(id);
  }

  // CREATE
  @Post('api/resume')
  create(@Body() body) {
    return this.service.create(body);
  }

  // UPDATE
  @Put('api/resume/:id')
  update(@Param('id') id: number, @Body() body) {
    return this.service.update(id, body);
  }

  // DELETE
  @Delete('api/resume/:id')
  delete(@Param('id') id: number) {
    return this.service.remove(id);
  }
}
