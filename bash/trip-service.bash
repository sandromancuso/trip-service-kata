get_trip_by_user() {
    local user="$1"
    local loggedUser=$(get_logged_user)
    local isFriend=false
    local triplist=()
    if [[ -n "$loggedUser" ]]
    then
        for friend in ${FRIENDS[$user]}
        do
            if [[ $friend == $loggedUser ]]
            then
                isFriend=true
                break
            fi
        done
        if [[ isFriend ]]
        then
            triplist=($(find_trip_by_user $user))
        fi
        echo "${triplist[@]}"
    else
        kill -SIGUSR1 $$
    fi
}

get_logged_user()
{
    >&2 echo "get_logged_user should not be called in an unit test"
    exit 2
}

find_trip_by_user()
{
    >&2 echo "find_trip_by_user should not be called in an unit test"
    exit 2
}
