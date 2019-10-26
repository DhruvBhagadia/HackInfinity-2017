## Project Details
Our project is build up into two parts.

**1.** Crop Predictor i.e which crop will be present at a particular farm by just observing the NDVI(MODIS) Index.
First we take a yearly data of NDVI(MODIS) VS Day of the Year(DOY) which is readily made available by the VEDAS.Then we take the CSV file of the required data and then we pass it through our peak predictor function which then plots the peaks i.e. red crosses on suitable crops yield.The way to detect peaks (local maxima) in a data set is to use the property that a peak must be greater than its immediate neighbors.

Then we get a small amount of peaks or a feasible one.Now the peak values got above is passed to the simple K Nearest Neighbor Classifier model trained by using a NDVI labeled dataset. The value of the prediction is the suggested crop that should be planted at that area.

**2.** Soil Fertilizer Predictor: The suggested crop will be given as the input to the fertilizer predictor part of the app with the N(Nitrogen)-P(Phosphorous)-K(Potash) values of the soil which they got when they checked their soil sample at a given lab. It gives the required quantity of the different fertilizers that will be required by the farmer to grow a decent yield of the crop.

Note: Our crop predictor is not completely liable enough right now as it gives only 54% of correct output for a given value but we intend to reduce the distortion of the dataset as well as use an advanced algorithm in the future.
## Screenshots:
**1.** Crop Predictor

![peaks](https://user-images.githubusercontent.com/26873907/35183944-459aae48-fe14-11e7-8920-317315fd2d29.png)

This was observed over the Kheda Region of Gujarat.

**2.** Soil Fertility Predictor App

![screenshot_20171112-164746](https://user-images.githubusercontent.com/26873907/35183968-992d1aa0-fe14-11e7-80a8-b92d3d4dc8be.png)

Our Models basically help farmers to know whether which crop is suitable in their field and is the fertility of the soil appropriate according to the crop requirement.
