import { promises } from 'fs'

export default class Submarine {
  constructor(aim) {
    this.horizontalPosition = 0
    this.depth = 0
    this.aim = aim ?? 0
  }

  moveForward(num) {
    this.horizontalPosition = this.horizontalPosition + num
    this.depth = this.depth + (num * this.aim)
  }

  moveDown(num) {
    this.aim = this.aim + num
  }

  moveUp(num) {
    this.aim = this.aim - num
  }

  navigate(instruction) {
    const instructions = instruction.split(' ')
    const direction = instructions[0]
    const amount = parseInt(instructions[1])

    switch(direction) {
      case('forward'): 
        this.moveForward(amount)
        break
      case('up'): 
        this.moveUp(amount)
        break
      case('down'): 
        this.moveDown(amount)
        break
    }
  }

  async readInstructions() {
    const data = await promises.readFile('instructions.txt', 'utf8')

    const readings = data.split('\n')
    return readings
  }
}