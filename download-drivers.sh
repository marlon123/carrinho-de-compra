#!/bin/bash
mkdir -p drivers
cd drivers
curl -L https://github.com/mozilla/geckodriver/releases/download/v0.26.0/geckodriver-v0.26.0-linux64.tar.gz | tar xvz
wget https://chromedriver.storage.googleapis.com/80.0.3987.16/chromedriver_linux64.zip -O temp.zip
unzip temp.zip
rm temp.zip