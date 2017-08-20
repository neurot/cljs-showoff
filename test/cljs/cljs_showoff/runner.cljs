(ns cljs-showoff.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [cljs-showoff.core-test]))

(doo-tests 'cljs-showoff.core-test)
