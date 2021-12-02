import Submarine from './'

describe('advent-of-code-2', () => {
  it('sets expected horizontal position when moving forward', () => {
    const sub = new Submarine()
    sub.moveForward(8)  
    expect(sub.horizontalPosition).toBe(8)
  })

  it('sets expected depth when moving forward', () => {
    const sub = new Submarine(5)
    sub.moveForward(8)  
    expect(sub.depth).toBe(40)
  })

  it('returns expected aim when moving down', () => {
    const sub = new Submarine()
    sub.moveDown(8)  
    expect(sub.aim).toBe(8)
  })

  it('returns expected aim when moving up', () => {
    const sub = new Submarine(5)
    sub.moveUp(2)

    expect(sub.aim).toBe(3)
  })

  it('can navigate forward', () => {
    const sub = new Submarine()
    const moveForwardSpy = jest.spyOn(sub, 'moveForward')
    const instruction = 'forward 8'

    sub.navigate(instruction)

    expect(moveForwardSpy).toHaveBeenCalledWith(8)
  })

  it('can navigate down', () => {
    const sub = new Submarine()
    const moveDownSpy = jest.spyOn(sub, 'moveDown')
    const instruction = 'down 8'

    sub.navigate(instruction)

    expect(moveDownSpy).toHaveBeenCalledWith(8)
  })

  it('can navigate up', () => {
    const sub = new Submarine()
    const moveUpSpy = jest.spyOn(sub, 'moveUp')
    const instruction = 'up 8'

    sub.navigate(instruction)

    expect(moveUpSpy).toHaveBeenCalledWith(8)
  })

  it('can read instructions', async () => {
    const sub = new Submarine()
    const instructions = await sub.readInstructions()

    expect(instructions.length).toBe(1000)
  })

  describe('integration test', () => {
    fit('should calculate sub position', async () => {
      const sub = new Submarine()
      
      const instructions = await sub.readInstructions()

      instructions.forEach(instruction => {
        sub.navigate(instruction)
      })

      console.log(`Horizontal position: ${sub.horizontalPosition}`)
      console.log(`Depth: ${sub.depth}`)

      console.log(`AOC result: ${sub.horizontalPosition * sub.depth}`)
    })  
  })
})