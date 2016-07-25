package com.apteligent.display;

import com.apteligent.types.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;

/**
 * Created by levy on 7/19/16.
 */
public class Diagnostics {
    @JsonProperty("continuous_bar_diagnostic_data")
    Object continuousBarDiagnosticData;

    @JsonProperty("continuous_diagnostic_data")
    Object continuousDiagnosticData;

    @JsonProperty("geo_data")
    Object geoData;

    @JsonProperty("discrete_diagnostic_data")
    Object discreteDiagnosticData;

    @JsonProperty("chart_data")
    Object chartData;

    @JsonProperty("affected_users")
    LinkedHashMap<String, User> affectedUsers;

    @JsonProperty("affected_versions")
    Object affectedVersions;

    @JsonProperty("num_geo_points")
    Object numGeoPoints;

    @JsonProperty("discrete_bar_diagnostic_data")
    Object discreteBarDiagnosticData;
}

/*


0 = {java.util.LinkedHashMap$Entry@1757} "continuous_bar_diagnostic_data" -> "{"memory_usage":{"data":[0,0,0,0,0,0,1,2,0,0,0,1,0,0,0,0],"categories":["0 MB-8 MB","8 MB-16 MB","16 MB-24 MB","24 MB-32 MB","32 MB-40 MB","40 MB-48 MB","48 MB-56 MB","56 MB-64 MB","64 MB-72 MB","72 MB-80 MB","80 MB-88 MB","88 MB-96 MB","96 MB-104 MB","104 MB-112 MB","112 MB-120 MB","120 MB-128 MB"]}}"
1 = {java.util.LinkedHashMap$Entry@1758} "continuous_diagnostic_data" -> "{"battery_level":{"max":"0.82","average":"0.5575","min":"0.27"},"memory_usage":{"max":"90 MB","average":"66 MB","min":"55 MB"},"disk_space_total":{"max":"26040 MB","average":"16916 MB","min":"5117 MB"},"sd_space_free":{"max":"11410 MB","average":"4905 MB","min":"1189 MB"},"sd_space_total":{"max":"26020 MB","average":"16901 MB","min":"5117 MB"},"disk_space_free":{"max":"11430 MB","average":"4920 MB","min":"1189 MB"}}"
2 = {java.util.LinkedHashMap$Entry@1759} "geo_data" -> "{"TW":{"--NAME--":"Taiwan","Taipei":[25.04,121.53,1.0]},"US":{"United States":[38.0,-97.0,1.0],"South Carolina":[33.82,-78.68,1.0],"New Jersey":[40.74,-74.03,1.0],"--NAME--":"United States"}}"
3 = {java.util.LinkedHashMap$Entry@1760} "discrete_diagnostic_data" -> "{"orientation":[["Portrait",4]],"locale":[["en",3],["zh",1]],"carrier":[["",2],["Chunghwa Telecom",1],["AT&T",1]],"model":[["SM-T350",1],["MotoE2(4G-LTE)",1],["SM-N910U",1],["SM-T710",1]],"app_version":[["4.0",4]],"system_version":[["android 5.1.1",2],["android 5.0.2",1],["android 5.1",1]]}"
4 = {java.util.LinkedHashMap$Entry@1761} "chart_data" -> "[{"name":"Occurrences","pointStart":1466294400051,"pointInterval":86400000,"id":"total","data":[0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0],"showInLegend":false}]"
 key = {java.lang.String@1774} "chart_data"
 value = {com.fasterxml.jackson.databind.node.ArrayNode@1775} "[{"name":"Occurrences","pointStart":1466294400051,"pointInterval":86400000,"id":"total","data":[0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0],"showInLegend":false}]"
  _children = {java.util.ArrayList@1840}  size = 1
   0 = {com.fasterxml.jackson.databind.node.ObjectNode@1842} "{"name":"Occurrences","pointStart":1466294400051,"pointInterval":86400000,"id":"total","data":[0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0],"showInLegend":false}"
  _nodeFactory = {com.fasterxml.jackson.databind.node.JsonNodeFactory@1628}
5 = {java.util.LinkedHashMap$Entry@1762} "affected_users" -> "{"918d640d-b026-3f1f-bc7b-96b2b6913e00":{"username":"dGtVryYdd7","app_version":"4.0","crash_last_occurred_iso":"2016-07-10T07:33:27.924+00:00","locale":null,"system":null,"carrier":null,"model":null,"last_login_time_iso":"2016-07-10T07:33:44.178Z","metadata":null},"35f33909-5573-3c0b-aaff-81a0b121f9e6":{"username":"lmxBfcJWFt","app_version":"4.0","crash_last_occurred_iso":"2016-07-08T07:34:01.425+00:00","locale":null,"system":null,"carrier":null,"model":null,"last_login_time_iso":"2016-07-08T07:34:07.859Z","metadata":null},"0e9731a0-ae1b-304f-b1ff-62aafc5be96d":{"username":"cXaUsox7Bs","app_version":"4.0","crash_last_occurred_iso":"2016-06-22T00:04:50.423+00:00","locale":null,"system":null,"carrier":null,"model":null,"last_login_time_iso":"2016-06-22T00:05:03.301Z","metadata":null},"2d2806c7-6b32-38c4-9899-76eb5cd0256d":{"username":"dBmopvRkXX","app_version":"4.0","crash_last_occurred_iso":"2016-07-13T07:58:43.252+00:00","locale":null,"system":null,"carrier":null,"
6 = {java.util.LinkedHashMap$Entry@1763} "affected_versions" -> "[["4.0",4]]"
7 = {java.util.LinkedHashMap$Entry@1764} "num_geo_points" -> "0"
8 = {java.util.LinkedHashMap$Entry@1765} "discrete_bar_diagnostic_data" -> "{"wifi":{"data":[4,3,0],"categories":["available","connected","failover"]},"mobile_network":{"data":[2,3,0,0,0],"categories":["available","connected","connecting","failover","roaming"]}}"


"diagnostics": {
    "continuous_bar_diagnostic_data": {
      "memory_usage": {
        "data": [
          260,
          384,
          477,
          444,
          447,
          495,
          484,
          425,
          220154,
          187834,
          0,
          0,
          0,
          0,
          0,
          0
        ],
        "categories": [
          "0 MB-256 MB",
          "256 MB-512 MB",
          "512 MB-768 MB",
          "768 MB-1024 MB",
          "1024 MB-1280 MB",
          "1280 MB-1536 MB",
          "1536 MB-1792 MB",
          "1792 MB-2048 MB",
          "2048 MB-2304 MB",
          "2304 MB-2560 MB",
          "2560 MB-2816 MB",
          "2816 MB-3072 MB",
          "3072 MB-3328 MB",
          "3328 MB-3584 MB",
          "3584 MB-3840 MB",
          "3840 MB-4096 MB"
        ]
      }
    },
    "continuous_diagnostic_data": {
      "battery_level": {
        "max": "0.0",
        "average": "0.0",
        "min": "0.0"
      },
      "memory_usage": {
        "max": "2522 MB",
        "average": "2259 MB",
        "min": "1 MB"
      },
      "disk_space_free": {
        "max": "11302 MB",
        "average": "5668 MB",
        "min": "0 MB"
      }
    },
    "geo_data": {
      "UY": {
        "--NAME--": "Uruguay",
        "Departamento de Montevideo": [
          -34.86,
          -56.17,
          55767
        ]
      },
      "TH": {
        "Bangkok": [
          13.78,
          100.58,
          11106
        ],
        "Thailand": [
          13.75,
          100.47,
          22089
        ],
        "null": [
          13.75,
          100.47,
          454
        ],
        "--NAME--": "Thailand"
      },
      "CL": {
        "--NAME--": "Chile",
        "Santiago Metropolitan": [
          -33.45,
          -70.67,
          11228
        ]
      },
      "TW": {
        "Taiwan": [
          23.5,
          121,
          7360
        ],
        "null": [
          23.5,
          121,
          157
        ],
        "--NAME--": "Taiwan",
        "Taipei": [
          25.04,
          121.53,
          45138
        ]
      },
      "PY": {
        "Paraguay": [
          -23,
          -58,
          18439
        ],
        "Departamento del Alto Parana": [
          -25.51,
          -54.61,
          3662
        ],
        "null": [
          -23,
          -58,
          426
        ],
        "--NAME--": "Paraguay"
      },
      "US": {
        "United States": [
          38,
          -97,
          11153
        ],
        "null": [
          38,
          -97,
          250
        ],
        "--NAME--": "United States",
        "Texas": [
          32.78,
          -96.8,
          3732
        ]
      },
      "HK": {
        "null": [
          22.3,
          114.2,
          487
        ],
        "Hong Kong": [
          22.3,
          114.2,
          22059
        ],
        "--NAME--": "Hong Kong"
      },
      "NZ": {
        "New Zealand": [
          -41,
          174,
          18108
        ],
        "null": [
          -41,
          174,
          446
        ],
        "--NAME--": "New Zealand",
        "Auckland": [
          -36.81,
          174.98,
          14996
        ]
      },
      "AU": {
        "Queensland": [
          -27.58,
          153.05,
          3644
        ],
        "Australia": [
          -27,
          133,
          10784
        ],
        "null": [
          -27,
          133,
          261
        ],
        "--NAME--": "Australia",
        "New South Wales": [
          -32.93,
          151.78,
          18692
        ]
      },
      "EC": {
        "Provincia del Azuay": [
          -2.88,
          -78.98,
          3810
        ],
        "Provincia del Guayas": [
          -2.17,
          -79.9,
          11130
        ],
        "--NAME--": "Ecuador",
        "Provincia de Pichincha": [
          -0.22,
          -78.5,
          15086
        ],
        "null": [
          -2,
          -77.5,
          104
        ],
        "Ecuador": [
          -2,
          -77.5,
          3599
        ]
      },
      "BR": {
        "Brazil": [
          -23.55,
          -46.64,
          18332
        ],
        "Sao Paulo": [
          -23.18,
          -45.88,
          11170
        ],
        "Para": [
          -1.7,
          -48.9,
          3635
        ],
        "Paraiba": [
          -7.22,
          -35.88,
          3715
        ],
        "Rio de Janeiro": [
          -22.9,
          -43.23,
          7552
        ],
        "--NAME--": "Brazil",
        "Pernambuco": [
          -7.98,
          -37.97,
          3752
        ],
        "null": [
          -23.55,
          -46.64,
          411
        ],
        "Rio Grande do Sul": [
          -30.03,
          -51.2,
          3847
        ]
      },
      "SG": {
        "null": [
          1.3,
          103.78,
          701
        ],
        "--NAME--": "Singapore",
        "Singapore": [
          1.3,
          103.78,
          33000
        ]
      },
      "MY": {
        "Kuala Lumpur": [
          3.17,
          101.7,
          3728
        ],
        "Selangor": [
          3.14,
          101.59,
          3713
        ],
        "Malaysia": [
          2.5,
          112.5,
          7403
        ],
        "Johor": [
          1.5,
          103.74,
          3818
        ],
        "null": [
          2.5,
          112.5,
          173
        ],
        "--NAME--": "Malaysia"
      },
      "ID": {
        "Indonesia": [
          -6.17,
          106.83,
          3598
        ],
        "null": [
          -6.17,
          106.83,
          81
        ],
        "--NAME--": "Indonesia",
        "Daerah Khusus Ibukota Jakarta": [
          -6.17,
          106.83,
          15007
        ]
      }
    },
    "discrete_diagnostic_data": {
      "on_wifi": [
        [
          "No",
          216689
        ],
        [
          "Yes",
          221114
        ]
      ],
      "on_cellular_data": [
        [
          "No",
          437803
        ],
        [
          "Yes",
          0
        ]
      ],
      "orientation": [
        [
          "FaceUp",
          434054
        ],
        [
          "LandscapeRight",
          934
        ],
        [
          "Portrait",
          923
        ],
        [
          "LandscapeLeft",
          960
        ],
        [
          "PortraitUpsideDown",
          932
        ]
      ],
      "locale": [
        [
          "de",
          33587
        ],
        [
          "fi",
          33698
        ],
        [
          "ko",
          33744
        ],
        [
          "zh-hk",
          33415
        ],
        [
          "zh-tw",
          33697
        ],
        [
          "gn",
          33786
        ],
        [
          "en",
          33749
        ],
        [
          "fr",
          33667
        ],
        [
          "zh-cn",
          33865
        ],
        [
          "ja",
          33441
        ],
        [
          "en-au",
          33813
        ],
        [
          "da",
          33798
        ],
        [
          "nl",
          33543
        ]
      ],
      "form_factor": [
        [
          "iPhone",
          1553
        ],
        [
          "iPad",
          434723
        ],
        [
          "iPod",
          1527
        ]
      ],
      "status_bar_orientation": [
        [
          "Portrait",
          437803
        ]
      ],
      "carrier": [
        [
          "att",
          144770
        ],
        [
          "t-mobile",
          144638
        ],
        [
          "T-Mobile",
          899
        ],
        [
          "VZW",
          961
        ],
        [
          "verizon",
          143749
        ],
        [
          "Sprint",
          927
        ],
        [
          "unknown",
          933
        ],
        [
          "AT&T",
          926
        ]
      ],
      "online": [
        [
          "No",
          0
        ],
        [
          "Yes",
          437803
        ]
      ],
      "model": [
        [
          "iPhone8,1",
          1161
        ],
        [
          "iPhone8,2",
          1227
        ],
        [
          "iPhone6,1",
          9971
        ],
        [
          "iPhone6,2",
          8803
        ],
        [
          "iPhone4,1",
          8973
        ],
        [
          "iPhone2,1",
          8751
        ],
        [
          "AppleTV2,1",
          8951
        ],
        [
          "iPod4,1",
          8812
        ],
        [
          "iPad5,4",
          9020
        ],
        [
          "iPad3,6",
          8719
        ],
        [
          "iPad3,5",
          8919
        ],
        [
          "iPad5,3",
          8916
        ],
        [
          "iPad3,4",
          8845
        ],
        [
          "iPad3,3",
          8748
        ],
        [
          "iPod2,1",
          8993
        ],
        [
          "iPad3,2",
          8932
        ],
        [
          "iPad3,1",
          8909
        ],
        [
          "iPad1,1",
          8829
        ],
        [
          "iPhone5,4",
          9005
        ],
        [
          "iPhone7,2",
          8961
        ],
        [
          "iPhone5,2",
          8754
        ],
        [
          "iPhone7,1",
          8772
        ],
        [
          "iPhone5,3",
          8627
        ],
        [
          "iPhone3,2",
          8807
        ],
        [
          "iPhone3,3",
          8831
        ],
        [
          "iPhone5,1",
          8810
        ],
        [
          "iPhone1,2",
          8658
        ],
        [
          "iPhone3,1",
          9011
        ],
        [
          "iPhone1,1",
          8836
        ],
        [
          "iPad4,9",
          8944
        ],
        [
          "iPod3,1",
          8828
        ],
        [
          "AppleTV1,1",
          8882
        ],
        [
          "iPad4,8",
          8852
        ],
        [
          "iPad4,7",
          8888
        ],
        [
          "iPod5,1",
          8816
        ],
        [
          "iPad4,6",
          8851
        ],
        [
          "iPad2,7",
          8782
        ],
        [
          "iPad4,5",
          8894
        ],
        [
          "iPad2,6",
          8794
        ],
        [
          "iPad4,4",
          8667
        ],
        [
          "AppleTV3,2",
          8744
        ],
        [
          "iPod1,1",
          8782
        ],
        [
          "iPad2,5",
          8932
        ],
        [
          "iPad4,3",
          8671
        ],
        [
          "AppleTV3,1",
          8752
        ],
        [
          "iPad2,4",
          8699
        ],
        [
          "iPad4,2",
          8908
        ],
        [
          "iPad2,3",
          8873
        ],
        [
          "iPad4,1",
          9940
        ],
        [
          "iPad2,2",
          8877
        ],
        [
          "iPad2,1",
          8876
        ]
      ],
      "app_version": [
        [
          "3.14",
          242
        ],
        [
          "dot_2",
          276
        ],
        [
          "1.0+1",
          260
        ],
        [
          "1.3.1",
          253
        ],
        [
          "6.6.1 (3705)",
          261
        ],
        [
          "1.0+2",
          239
        ],
        [
          "1.0",
          246
        ],
        [
          "1.0+3",
          266
        ],
        [
          "1.1",
          254
        ],
        [
          "1.2",
          262
        ],
        [
          "1.3",
          247
        ],
        [
          "1.0.2.4",
          256
        ],
        [
          "1.4",
          258
        ],
        [
          "6.6.1 (3700)",
          259
        ],
        [
          "0.9",
          260
        ],
        [
          "1.1a",
          271
        ],
        [
          "6.6.1 (3702)",
          266
        ],
        [
          "1.0.1",
          433427
        ]
      ],
      "system_version": [
        [
          "ios 7.1.2",
          918
        ],
        [
          "ios 7.0.4",
          433157
        ],
        [
          "ios 8.4",
          969
        ],
        [
          "ios 6.1",
          938
        ],
        [
          "ios 7.1",
          890
        ],
        [
          "ios 8.0",
          931
        ]
      ]
    },
    "chart_data": [
      {
        "name": "Occurrences",
        "pointStart": 1466294400119,
        "pointInterval": 86400000,
        "id": "total",
        "data": [
          17397,
          16123,
          17309,
          18910,
          12325,
          11907,
          12073,
          12205,
          12354,
          11964,
          13141,
          12750,
          16906,
          19642,
          19210,
          19221,
          18906,
          15524,
          12529,
          15198,
          12749,
          8823,
          10602,
          15971,
          14816,
          14700,
          11354,
          10305,
          10218,
          12036,
          10635
        ],
        "showInLegend": false
      }
    ],
    "affected_users": {
      "c076570e2945abbc2103084a60c90c1b78429d55a5441eb7bbdd187d5a7fad74g": {
        "username": "User-7HM330A",
        "app_version": "1.0.2.4",
        "crash_last_occurred_iso": "2016-06-20T07:08:47.000+00:00",
        "locale": null,
        "system": null,
        "carrier": null,
        "model": null,
        "last_login_time_iso": "2016-07-19T21:45:18.076Z",
        "metadata": null
      },
      "c076570e2945abbc2103084a60c90c1b78429d55a5441eb7bbdd187d5a7fadd4g": {
        "username": "User-6NN152G",
        "app_version": "1.3",
        "crash_last_occurred_iso": "2016-06-22T07:08:16.000+00:00",
        "locale": null,
        "system": null,
        "carrier": null,
        "model": null,
        "last_login_time_iso": "2016-07-19T21:45:20.891Z",
        "metadata": null
      },
      "c076570e2945abbc2103084a60c90c1b78429d55a5441eb7bbdd187d5a7fad14g": {
        "username": "User-7409X49",
        "app_version": "6.6.1 (3705)",
        "crash_last_occurred_iso": "2016-07-19T21:21:22.979+00:00",
        "locale": null,
        "system": null,
        "carrier": null,
        "model": null,
        "last_login_time_iso": "2016-07-19T21:45:20.719Z",
        "metadata": null
      },
      "c076570e2945abbc2103084a60c90c1b78429d55a5441eb7bbdd187d5a7fad94g": {
        "username": "User-6NN158G",
        "app_version": "1.1a",
        "crash_last_occurred_iso": "2016-06-19T07:07:59.000+00:00",
        "locale": null,
        "system": null,
        "carrier": null,
        "model": null,
        "last_login_time_iso": "2016-07-19T21:45:23.632Z",
        "metadata": null
      }
    },
    "affected_versions": [
      [
        "3.14",
        242
      ],
      [
        "dot_2",
        276
      ],
      [
        "1.0+1",
        260
      ],
      [
        "1.3.1",
        253
      ],
      [
        "6.6.1 (3705)",
        261
      ],
      [
        "1.0+2",
        239
      ],
      [
        "1.0",
        246
      ],
      [
        "1.0+3",
        266
      ],
      [
        "1.1",
        254
      ],
      [
        "1.2",
        262
      ],
      [
        "1.3",
        247
      ],
      [
        "1.0.2.4",
        256
      ],
      [
        "1.4",
        258
      ],
      [
        "6.6.1 (3700)",
        259
      ],
      [
        "0.9",
        260
      ],
      [
        "1.1a",
        271
      ],
      [
        "6.6.1 (3702)",
        266
      ],
      [
        "1.0.1",
        433427
      ]
    ],
    "num_geo_points": 0,
    "discrete_bar_diagnostic_data": {}
  }

 */