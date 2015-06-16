#!/bin/bash
# post to twitter
echo -n Username:
read -n username
echo
echo -s Password:
echo
echo Tweet:
read -n tweet
url -u $username:$password -d status=$tweet http://twitter.com/statuses/update.xml