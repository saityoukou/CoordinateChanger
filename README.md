# CoordinateChanger
Android scroll animation like design library coordinatorlayout


![](https://raw.githubusercontent.com/saityoukou/CoordinateChanger/master/app/images/demo0.gif)


## Usage
```
                //set header action
                mCoordinateScrollHelper.addScrollObserver(mImageView,
                        new TranslationRateChangerBuilder()
                                .setChangerType(ChangerType.TRANSLATION_Y)
                                .setSpeedOfRelative(0.5f)
                        ,
                        new AlphaChangerBuilder()
                                .setFromAlpha(1.0f)
                                .setToAlpha(0.0f)
                                .setDuration(500)
                                .setMultiplier(0.4f)
                );
```



## License

```license
Copyright 2015 Sai tyoukou

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
