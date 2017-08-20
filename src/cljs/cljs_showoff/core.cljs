(ns cljs-showoff.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [cljs-showoff.events]
            [cljs-showoff.subs]
            [cljs-showoff.routes :as routes]
            [cljs-showoff.views :as views]
            [cljs-showoff.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
        (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))
