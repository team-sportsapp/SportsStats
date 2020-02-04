import pandas as import pd
import numpy as np


def team_name_change(season_box_scores):
    for season in season_box_scores:
        season_box_scores[season].replace('NEW ORLEANS HORNETS', 'NEW ORLEANS PELICANS',inplace=True)
        season_box_scores[season].replace('CHARLOTTE BOBCATS', 'CHARLOTTE HORNETS',inplace=True)
        season_box_scores[season].replace('NEW JERSEY NETS', 'BROOKLYN NETS',inplace=True)
        season_box_scores[season].replace('SEATTLE SUPERSONICS','OKLAHOMA CITY THUNDER',inplace=True)

def team_box_scores(data,team):
    return data[data['home_team']==team].append(data[data['away_team']==team]).sort_values(['year','month','day'],axis = 0,ascending=True)


def is_home(data,team,index):
    return data.loc[index,'home_team'] == team

def is_away(data,team,index):
    return data.loc[index,'away_team'] == team

    

def format_schedule(schedule):

    data = pd.DataFrame(columns = ['year', 'month', 'day', 'away_team','home_team',
                                   'away_score','home_score'])

    for i in range(0,len(schedule)):
        data.loc[i,'year'] = schedule[i]['start_time'].strftime('%Y')
        data.loc[i,'month'] = schedule[i]['start_time'].strftime('%m')
        data.loc[i,'day'] = schedule[i]['start_time'].strftime('%d')
        #data.loc[i,'date'] = schedule[i]['start_time']
        data.loc[i,'away_team'] = schedule[i]['away_team'].value
        data.loc[i,'home_team'] = schedule[i]['home_team'].value
        data.loc[i,'away_score'] = schedule[i]['away_team_score']
        data.loc[i,'home_score'] = schedule[i]['home_team_score']
        '''if data.loc[i,'away_score'] is not None:
            data.loc[i,'away_score'] =data.loc[i,'away_score'].astype(np.int32)
            data.loc[i,'home_score'] =data.loc[i,'home_score'].astype(np.int32)'''

    data['year'] = data['year'].astype(np.int32)
    data['month'] =data['month'].astype(np.int32)
    data['day'] =data['day'].astype(np.int32)

    return data


def fill_schedule_info(data):

    for team in teams:
        games_played=0
        points_for= 0
        points_against = 0
        wins =0
        win_streak=0
        road_trip_count= 0
        last_ten_wins= np.zeros(10)
        road_games_played=0
        home_games_played=0
        road_games_won=0
        home_games_won=0

        data_temp = team_box_scores(data,team)
        data_index = data_temp.index


        for i in range(0,len(data_temp)-1):

            if data.loc[data_index[i],'home_team'] == team:
                if data.loc[data_index[i],'home_score'] > data.loc[data_index[i],'away_score']:
                    data.loc[data_index[i],'home_team_won'] = 1
                    last_ten_wins[i%10] = 1
                    wins = wins+1
                    home_games_won = home_games_won+1
                    win_streak = win_streak+1
                else:
                    data.loc[data_index[i],'home_team_won'] = 0
                    last_ten_wins[i%10] = 0
                    win_streak = 0

                points_for = points_for + data.loc[data_index[i],'home_score']
                points_against = points_against + data.loc[data_index[i],'away_score']

                '''if data.loc[data_index[i],'home_score'] > data.loc[data_index[i],'away_score']:
                    wins = wins+1
                    home_games_won = home_games_won+1
                    win_streak = win_streak+1
                else:
                    win_streak = 0
                data.loc[data_index[i+1],'home_win_streak'] = win_streak'''

                games_played=games_played+1
                data.loc[data_index[i],'home_game_count'] = games_played
                home_games_played = home_games_played + 1
                road_trip_count=0


                if data.loc[data_index[i+1],'home_team'] == team:
                    data.loc[data_index[i+1],'avg_home_points_per_game'] = points_for/games_played
                    data.loc[data_index[i+1],'avg_home_points_against_per_game'] = points_against/games_played
                    data.loc[data_index[i+1],'home_win_percentage'] = wins/games_played
                    data.loc[data_index[i+1],'home_win_streak'] = win_streak
                    data.loc[data_index[i+1],'home_last_ten_wins'] = len(last_ten_wins[last_ten_wins==1])
                    if home_games_played > 0:
                        data.loc[data_index[i+1],'home_court_win_percentage'] = home_games_won/home_games_played
                    data.loc[data_index[i+1],'home_games_played'] = home_games_played
                else:
                    data.loc[data_index[i+1],'avg_away_points_per_game'] = points_for/games_played
                    data.loc[data_index[i+1],'avg_away_points_against_per_game'] = points_against/games_played
                    data.loc[data_index[i+1],'away_win_percentage'] = wins/games_played
                    data.loc[data_index[i+1],'away_win_streak'] = win_streak
                    data.loc[data_index[i+1],'away_last_ten_wins'] = len(last_ten_wins[last_ten_wins==1])
                    if road_games_played > 0:
                        data.loc[data_index[i+1],'road_win_percentage'] = road_games_won/road_games_played
                    data.loc[data_index[i+1],'away_games_played'] = road_games_played





            if data.loc[data_index[i],'away_team'] == team:
                points_for=points_for + data.loc[data_index[i],'away_score']
                points_against= points_against+data.loc[data_index[i],'home_score']
                if data.loc[data_index[i],'away_score'] > data.loc[data_index[i],'home_score']:
                    wins= wins + 1
                    road_games_won = road_games_won + 1
                    win_streak = win_streak + 1
                else:
                    win_streak = 0

                games_played=games_played+1
                data.loc[data_index[i],'away_game_count'] = games_played
                road_games_played = road_games_played + 1

                if data.loc[data_index[i],'home_score'] > data.loc[data_index[i],'away_score']:
                    data.loc[data_index[i],'home_team_won'] = 1
                    last_ten_wins[i%10] = 0
                else:
                    data.loc[data_index[i],'home_team_won'] = 0
                    last_ten_wins[i%10] = 1

                road_trip_count = road_trip_count + 1
                data.loc[data_index[i],'road_trip_count'] = road_trip_count


                if data.loc[data_index[i+1],'away_team'] == team:
                    data.loc[data_index[i+1],'avg_away_points_per_game'] = points_for/games_played
                    data.loc[data_index[i+1],'avg_away_points_against_per_game'] = points_against/games_played
                    data.loc[data_index[i+1],'away_win_percentage'] = wins/games_played
                    data.loc[data_index[i+1],'away_win_streak'] = win_streak
                    if road_games_played > 0:
                        data.loc[data_index[i+1],'road_win_percentage'] = road_games_won/road_games_played
                    data.loc[data_index[i+1],'away_games_played'] = road_games_played
                    data.loc[data_index[i+1],'away_last_ten_wins'] = len(last_ten_wins[last_ten_wins==1])
                else:
                    data.loc[data_index[i+1],'avg_home_points_per_game'] = points_for/games_played
                    data.loc[data_index[i+1],'avg_home_points_against_per_game'] = points_against/games_played
                    data.loc[data_index[i+1],'home_win_percentage'] = wins/games_played
                    data.loc[data_index[i+1],'home_win_streak'] = win_streak
                    if home_games_played > 0:
                        data.loc[data_index[i+1],'home_court_win_percentage'] = home_games_won/home_games_played
                    data.loc[data_index[i+1],'home_games_played'] = home_games_played
                    data.loc[data_index[i+1],'home_last_ten_wins'] = len(last_ten_wins[last_ten_wins==1])

            if i == len(data_index)-2:

                if data.loc[data_index[i+1],'home_team'] == team:
                    if data.loc[data_index[i+1],'home_score'] > data.loc[data_index[i+1],'away_score']:
                        data.loc[data_index[i+1],'home_team_won'] = 1
                        last_ten_wins[i%10] = 1
                        last_ten_wins[i%10] = 1
                        wins = wins+1
                        home_games_won = home_games_won+1
                    else:
                        data.loc[data_index[i+1],'home_team_won'] = 0
                        last_ten_wins[i%10] = 0
                    points_for = points_for + data.loc[data_index[i+1],'home_score']
                    points_against = points_against + data.loc[data_index[i+1],'away_score']
                    games_played=games_played+1
                    data.loc[data_index[i+1],'home_game_count'] = games_played
                else:
                    points_for=points_for + data.loc[data_index[i+1],'away_score']
                    points_against= points_against+data.loc[data_index[i+1],'home_score']
                    road_trip_count +=1
                    data.loc[data_index[i+1],'road_trip_count'] = road_trip_count

                    if data.loc[data_index[i+1],'away_score'] > data.loc[data_index[i+1],'home_score']:
                        wins= wins + 1
                        road_games_won = road_games_won + 1

                    games_played=games_played+1
                    data.loc[data_index[i+1],'away_game_count'] = games_played

    return data




def initial_column_fill(season_box_scores):

    data = season_box_scores[season]

    data['avg_home_points_per_game'] = np.zeros(len(data))
    data['avg_home_points_against_per_game'] = np.zeros(len(data))
    data['avg_away_points_per_game'] = np.zeros(len(data))
    data['avg_away_points_against_per_game'] = np.zeros(len(data))
    data['home_win_percentage'] = np.zeros(len(data))
    data['away_win_percentage'] = np.zeros(len(data))
    data['road_trip_count'] = np.zeros(len(data))
    data['home_last_ten_wins'] = np.zeros(len(data))
    data['away_last_ten_wins'] = np.zeros(len(data))
    data['home_win_streak'] = np.zeros(len(data))
    data['away_win_streak'] = np.zeros(len(data))
    data['home_games_played'] = np.zeros(len(data))
    data['away_games_played'] = np.zeros(len(data))
    data['home_team_won'] = np.zeros(len(data))
    data['home_court_win_percentage'] = np.zeros(len(data))
    data['road_win_percentage'] = np.zeros(len(data))
    data['home_game_count'] = np.zeros(len(data))
    data['away_game_count'] = np.zeros(len(data))
