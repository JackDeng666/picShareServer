package edu.gq.bbpic.service;

import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.pojo.Collect;
import edu.gq.bbpic.pojo.Praise;

public interface StaService {
    ServerResponse togglePraise(Praise praise);

    ServerResponse toggleCollect(Collect collect);

    ServerResponse getPraiseAndCollectInfo(int userId, int pictureId);
}
