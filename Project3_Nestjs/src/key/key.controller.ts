import { Controller, Get, Post, Put, Delete, Param, Body, UseGuards } from '@nestjs/common';
import { KeyService } from './key.service';
import { AuthGuard } from '@nestjs/passport';
import { RolesGuard } from '../JWT/auth.guard';

@Controller('api/key')
export class KeyController {

  constructor(private service: KeyService) {}

  @Get()
  getAll() {
    return this.service.findAll();
  }

  @Get(':id')
  getOne(@Param('id') id: number) {
    return this.service.findOne(id);
  }

  @UseGuards(AuthGuard('jwt'), RolesGuard)
  @Post()
  create(@Body() body) {
    return this.service.create(body);
  }

  @UseGuards(AuthGuard('jwt'), RolesGuard)
  @Put(':id')
  update(@Param('id') id: number, @Body() body) {
    return this.service.update(id, body);
  }

  @UseGuards(AuthGuard('jwt'), RolesGuard)
  @Delete(':id')
  remove(@Param('id') id: number) {
    return this.service.remove(id);
  }
}