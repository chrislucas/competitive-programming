package src.com.br.cp.site.codesignal.companies.uber.easy

// https://app.codesignal.com/company-challenges/uber/HNQwGHfKAoYsz9KX6
// DONE

fun solution(
    ride_time: Int, ride_distance: Int,
    cost_per_minute: MutableList<Double>,
    cost_per_mile: MutableList<Double>
): MutableList<Double> =

    cost_per_minute.zip(cost_per_mile).map { (perMinute, perMile) ->
        ride_time * perMinute + ride_distance * perMile
    }.toMutableList()

