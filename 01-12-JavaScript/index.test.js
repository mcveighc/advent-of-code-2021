import { 
  hasDepthIncreased, 
  calculateDepthWindow, 
  getDepthIncreaseCount, 
  getReadings 
} from './index'

describe('advent-of-code-1', () => {
  describe('hasDepthIncreased', () => {
    it('should return true when depth window has increased', () => {
      const prevReading = 10
      const currReading = 11

      const hasIncreased = hasDepthIncreased(prevReading,currReading)
      expect(hasIncreased).toBe(true)
    })

    it('should return false when depth has not increased', () => {
      const prevReading = 11
      const currReading = 10

      const hasIncreased = hasDepthIncreased(prevReading, currReading)
      expect(hasIncreased).toBe(false)
    })
  })
  
  describe('calculateDepthWindow', () => {
    it('should calculate total result from depthWindow', () => {
      const depthWindow = [1, 2, 3]
      const calculation = calculateDepthWindow(depthWindow)
  
      expect(calculation).toBe(6)
    })

  })

  describe('getDepthIncreasedCount', () => {
    it('should return expected sliding window increase count', () => {
      const depths = [199, 200, 208, 210, 200, 207, 240, 269, 260, 263]
      const depthIncreaseCount = getDepthIncreaseCount(depths)

      expect(depthIncreaseCount).toBe(5)
    })
  })

  describe('integration tests', () => {
    it('should return expected number of readings from input file', async () => {
      const readings = await getReadings()
      expect(readings.length).toBe(2000)
    })

    it('should return depthIncrasesCount', async () => {
      expect.assertions(0)
      const readings = await getReadings()
      const increasecount = getDepthIncreaseCount(readings)
      
      console.log(`Total depth increases for input readings; ${increasecount}`)
    })
  })
})