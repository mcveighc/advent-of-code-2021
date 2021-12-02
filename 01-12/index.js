import { promises } from 'fs'

function calculateDepthWindow(depthWindow) {
  const reducer = (previous, current) => previous + current
  return depthWindow.reduce(reducer)
}

function hasDepthWindowIncreased(prev, current) {
  return current > prev
}

function getDepthIncreaseCount(readings) {
  let increaseCount = 0

  for(let i = 3; i < readings.length; i++) {
   const prevDepthWindow = readings.slice(i-3, i)
   const currDepthWindow = readings.slice(i-2, i+1)

   const prevDepthWindowSum = calculateDepthWindow(prevDepthWindow)
   const currDepthWindowSum = calculateDepthWindow(currDepthWindow)

   const hasIncreased = hasDepthWindowIncreased(prevDepthWindowSum, currDepthWindowSum)

   if (hasIncreased) {
    console.log(`${currDepthWindowSum} increased`)
    increaseCount = increaseCount + 1
   } else {
     console.log(`${currDepthWindowSum} decreased`)
   }
  }

  return increaseCount
}

async function getReadings() {
  const data = await promises.readFile('readings.txt', 'utf8')

  const readings = data.split('\n').map(n => parseInt(n))
  return readings
}

module.exports = { hasDepthIncreased: hasDepthWindowIncreased, calculateDepthWindow, getDepthIncreaseCount, getReadings }